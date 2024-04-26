package BackenProject.service.carnetService;

import BackenProject.dto.CarnetDTO;
import BackenProject.dto.EnfantDTO;
import BackenProject.dto.VaccinationDTO;
import BackenProject.mapper.carnetMapper.CarnetMapper;
import BackenProject.mapper.enfantMapper.EnfantMapper;
import BackenProject.mapper.userMapper.UserMapper;
import BackenProject.mapper.vaccinationMapper.VaccinationMapper;
import BackenProject.model.Carnet;
import BackenProject.model.Enfant;
import BackenProject.model.User;
import BackenProject.model.Vaccination;
import BackenProject.repository.CarnetRepository;
import BackenProject.repository.EnfantRepository;
import BackenProject.repository.UserRepository;
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
public class CarnetServiceImpl implements CarnetService{

    private CarnetRepository carnetRepository;

    private CarnetMapper carnetMapper;

    private EnfantRepository enfantRepository;

    private UserRepository utilisateurRepository;

    private UserMapper utilisateurMapper;

    private EnfantMapper enfantMapper;

    private VaccinationMapper vaccinationMapper;









    @Override
    public List<CarnetDTO> readCarnets(){

        List<Carnet> carnets=carnetRepository.findAll();

        List<CarnetDTO> carnetDTOList1=carnets.stream().map(
                carnet -> carnetMapper.asCarnetDTO(carnet)
        ).toList();
        return carnetDTOList1;
    }

    @Override
    public List<CarnetDTO> getCarnetsById(Long idParent){
        List<Carnet> carnets = carnetRepository.findCarnetByParent_Id(idParent);
        if(carnets ==null)
            throw new EntityNotFoundException(MessageFormat.format("Not found Parent with id {0}", idParent));

//        System.out.println(carnet);
//        CarnetDTO carnetDTO =carnetMapper.asCarnetDTO(carnet);
//        carnetDTO.setId(carnet.getId());
//        carnetDTO.setNom(carnet.getParent().getNom());
//        carnetDTO.setAddresse(carnet.getParent().getAddresse());
//        carnetDTO.setEmail(carnet.getParent().getEmail());
//        carnetDTO.setPrenom(carnet.getParent().getPrenom());
//        carnetDTO.setTelephone(carnet.getParent().getTelephone());
//        carnetDTO.setPassword(carnet.getParent().getPassword());
        //carnetDTO.getEnfantDTO().setDateDeNaissance(carnet.getEnfant().getDateDeNaissance());
        //carnetDTO.getEnfantDTO().setNom(carnet.getEnfant().getNom());
        //carnetDTO.getEnfantDTO().setPrenom(carnet.getEnfant().getPrenom());
        //carnetDTO.getEnfantDTO().setSexe(carnet.getEnfant().getSexe());
        //CarnetDTO carnetDTO=carnetMapper.asCarnetDTO(carnet);

        List<CarnetDTO> carnetDTOList1=carnets.stream()
                .map(carnet -> carnetMapper.asCarnetDTO(carnet)).collect(Collectors.toList());



        return carnetDTOList1;
    }

    @Override
    public CarnetDTO getCarnetByEnfantId(Long idEnfant) {
        Carnet carnet=carnetRepository.findCarnetByEnfant_Id(idEnfant);
        return carnetMapper.asCarnetDTO(carnet);
    }

    @Override
    public CarnetDTO createCarnet(EnfantDTO enfantDTO, Long idParent){

        User user=utilisateurRepository.findById(idParent).orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Paren t with id {0}", idParent)));




        Enfant enfant=enfantMapper.asEnfant(enfantDTO);
        enfant.setParent(user);
        Enfant enfant1=enfantRepository.save(enfant);

        Carnet carnet=new Carnet();
        carnet.setEnfant(enfant1);
        carnet.setParent(user);
        Carnet carnet1=carnetRepository.save(carnet);

        CarnetDTO carnetDTO=new CarnetDTO();
        carnetDTO.setParentDTO(utilisateurMapper.asUserDTO(user));
        carnetDTO.setEnfantDTO(enfantMapper.asEnfantDTO(enfant1));

        return carnetMapper.asCarnetDTO(carnet1);
    }

    @Override
    public CarnetDTO updateCarnet(CarnetDTO carnetDTO) {
        return null;
    }

    @Override
    public void deleteCarnet(Long CarnetDTOId) {
        Carnet carnet= carnetRepository.findById(CarnetDTOId).
                orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Carnet with id {0}", CarnetDTOId)));

        carnetRepository.delete(carnet);
    }

    @Override
    public void ajouterVaccination(VaccinationDTO vaccinationDTO,Long carnetId) {
        Carnet carnet=carnetRepository.findById(carnetId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Carnet t with id {0}", carnetId)));

        Vaccination vaccination=vaccinationMapper.asVaccination(vaccinationDTO);

        carnet.getVaccinationList().add(vaccination);
        vaccination.setCarnet(carnet);

    }

    @Override
    public void enleverVaccination(Long vaccinationId) {

    }


}
