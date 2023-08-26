package br.com.siges.services;

import br.com.siges.models.SchoolGrade;
import br.com.siges.models.Sponsor;
import br.com.siges.models.Student;
import br.com.siges.repositories.SchoolGradeRepository;
import br.com.siges.repositories.SponsorRepository;
import br.com.siges.repositories.StudentRepository;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SchoolGradeRepository schoolGradeRepository;

    @Autowired
    private SponsorRepository sponsorRepository;

    @Transactional
    public Student save(Student student, long idSchoolGrade) {
        SchoolGrade schoolGrade = schoolGradeRepository.findById(idSchoolGrade).orElseThrow();
        student.setCurrentSchoolGrade(schoolGrade);
        List<Sponsor> sponsors = student.getSponsors();
        ArrayList<Sponsor> sponsorsList = new ArrayList<Sponsor>();
        for (int i = 0; i < student.getSponsors().size(); i++) {
            if (!student.getSponsors().get(i).getName().isEmpty() && !student.getSponsors().get(i).getCpf().isEmpty()) {
                Sponsor fetchedSponsor = sponsorRepository.findByCpf(sponsors.get(i).getCpf()).orElse(null);
                if (fetchedSponsor != null) {
                    fetchedSponsor.setName(sponsors.get(i).getName());
                    fetchedSponsor.setCpf(sponsors.get(i).getCpf());
                    sponsorsList.add(fetchedSponsor);
                } else {
                    sponsorsList.add(sponsors.get(i));
                }
            }
        }
        student.setSponsors(sponsorsList);
        return studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
