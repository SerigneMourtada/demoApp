package BackenProject.service.vaccinationService;

import BackenProject.dto.*;
import BackenProject.mapper.carnetMapper.CarnetMapper;
import BackenProject.mapper.consultationMapper.ConsultationMapper;
import BackenProject.mapper.userMapper.UserMapper;
import BackenProject.mapper.vaccinMapper.VaccinMapper;
import BackenProject.mapper.vaccinationMapper.VaccinationMapper;
import BackenProject.model.*;
import BackenProject.repository.*;
import BackenProject.service.carnetService.CarnetService;
import BackenProject.service.vaccinService.VaccinService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class VaccinationServiceImpl implements VaccinationService{

  private VaccinationRepository vaccinationRepository;

  private VaccinationMapper vaccinationMapper;

  private CarnetRepository carnetRepository;

  private CarnetMapper carnetMapper;

  private UserRepository userRepository;

  private UserMapper userMapper;

  private VaccinRepository vaccinRepository;

  private VaccinMapper vaccinMapper;

  private ConsultationRepository consultationRepository;

  private ConsultationMapper consultationMapper;




    @Override
    public List<VaccinationDTO> readVaccinations(){
        List<Vaccination> vaccinationList=vaccinationRepository.findAll();
        List<VaccinationDTO> vaccinationDTOList=vaccinationList.stream().map(vaccination -> vaccinationMapper.asVaccinationDTO(vaccination))
                .collect(Collectors.toList());
        return vaccinationDTOList;
    }

    @Override
    public VaccinationDTO getVaccinationById(Long vaccinationId){
        Vaccination vaccination=vaccinationRepository.findById(vaccinationId)
                .orElseThrow(()-> new EntityNotFoundException(MessageFormat.format("Not found Vaccination with id {0}",vaccinationId)));
        return vaccinationMapper.asVaccinationDTO(vaccination);
    }

    @Override
    public VaccinationDTO createVaccination(VaccinationCreationRequest vaccinationCreationRequest){
        Carnet carnet = carnetRepository.findById(vaccinationCreationRequest.getCarnetId())
                .orElseThrow( ()-> new EntityNotFoundException(
                        MessageFormat.format("Not found Carnet with id {0}",vaccinationCreationRequest.getCarnetId())
                ));

         User user= userRepository.findById(vaccinationCreationRequest.getMedcinId())
                 . orElseThrow(()-> new EntityNotFoundException(MessageFormat.format("Not found Medcin with id {0}",vaccinationCreationRequest.getMedcinId())));

         Vaccin vaccin =vaccinRepository.findById(vaccinationCreationRequest.getVaccinId())
                            . orElseThrow(()-> new EntityNotFoundException(MessageFormat.format("Not found Vaccin with id {0}",vaccinationCreationRequest.getVaccinId())));

        Consultation consultation=new Consultation();
        consultation.setPoids(vaccinationCreationRequest.getPoids());
        consultation.setTemperature(vaccinationCreationRequest.getTemperature());
        Consultation consultation1=consultationRepository.save(consultation);

        Vaccination vaccination = new Vaccination();
        vaccination.setConsultation(consultation1);
        vaccination.setDate(vaccinationCreationRequest.getDate());
        vaccination.setNombreDeDose(vaccinationCreationRequest.getNombreDeDose());
        vaccination.setCarnet(carnet);
        vaccination.setVaccin(vaccin);
        vaccination.setMedcin(user);
        vaccinationRepository.save(vaccination);

        carnet.getVaccinationList().add(vaccination);
        carnetRepository.save(carnet);

        ConsultationDTO consultationDTO=consultationMapper.asConsultationDTO(consultation);


        VaccinationDTO vaccinationDTO=vaccinationMapper.asVaccinationDTO(vaccination);
        vaccinationDTO.setConsultationDTO(consultationDTO);
        return vaccinationDTO;
    }

    @Override
    public VaccinationDTO updateVaccination(VaccinationDTO vaccinationDTO){
        Vaccination vaccination= vaccinationRepository.findById(vaccinationDTO.getId())
                .orElseThrow((() -> new EntityNotFoundException(MessageFormat.format("Not found Vaccin with id {0}",vaccinationDTO.getId()))));
        Vaccination vaccination1=vaccinationRepository.save(vaccination);
        return vaccinationMapper.asVaccinationDTO(vaccination1);

    }

    @Override
    public void deleteVaccination(Long vaccinationId){
        vaccinationRepository.deleteById(vaccinationId);

    }

    @Override
    public List<VaccinationDTO> getVaccinationByIdCarnet(Long carnetId) {
       List<Vaccination> vaccinations= vaccinationRepository.getVaccinationByCarnetId(carnetId);
      List<VaccinationDTO> vaccinationDTOList= vaccinations.stream().map(vaccination -> vaccinationMapper.asVaccinationDTO(vaccination))
               .collect(Collectors.toList());

        return vaccinationDTOList;
    }
}
