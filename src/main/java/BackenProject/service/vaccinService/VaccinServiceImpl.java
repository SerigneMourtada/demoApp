package BackenProject.service.vaccinService;

import BackenProject.dto.VaccinDTO;
import BackenProject.mapper.vaccinMapper.VaccinMapper;
import BackenProject.model.Vaccin;
import BackenProject.model.Vaccination;
import BackenProject.repository.VaccinRepository;
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


public class VaccinServiceImpl implements VaccinService{

    private VaccinRepository vaccinRepository;

   private VaccinMapper vaccinMapper;

    //private VaccinMapperTest vaccinMapperTest;

    @Override
    public List<VaccinDTO> readVaccins(){
       List<Vaccin> vaccinList=vaccinRepository.findAll();
        List<VaccinDTO> vaccinDTOList=vaccinList.stream().map(vaccin -> vaccinMapper.asVaccinDTO(vaccin))
                .collect(Collectors.toList());
        return vaccinDTOList;
    }

    @Override
    public VaccinDTO getVaccinById(Long vaccinId){
        Vaccin vaccin= vaccinRepository.findById(vaccinId)
                .orElseThrow((() -> new EntityNotFoundException(MessageFormat.format("Not found Vaccin with id {0}", vaccinId))));
        return vaccinMapper.asVaccinDTO(vaccin);
    }

    @Override
    public VaccinDTO createVaccin(VaccinDTO vaccinDTO){
        Vaccin vaccin=vaccinMapper.asVaccin(vaccinDTO);
        System.out.println("=========>"+vaccinDTO);
        Vaccin vaccin1=vaccinRepository.save(vaccin);
        return vaccinMapper.asVaccinDTO(vaccin1);
    }

    @Override
    public VaccinDTO updateVaccin(VaccinDTO vaccinDTO){
        Vaccin vaccin= vaccinRepository.findById(vaccinDTO.getId())
                .orElseThrow((() -> new EntityNotFoundException(MessageFormat.format("Not found Vaccin with id {0}",vaccinDTO.getId()))));
        Vaccin vaccin1=vaccinRepository.save(vaccin);
        return vaccinMapper.asVaccinDTO(vaccin1);
    }

    @Override
    public void deleteVaccin(Long vaccinId){
        Vaccin vaccin= vaccinRepository.findById(vaccinId)
                .orElseThrow((() -> new EntityNotFoundException(MessageFormat.format("Not found Vaccin with id {0}", vaccinId))));
        vaccinRepository.delete(vaccin);

    }



}
