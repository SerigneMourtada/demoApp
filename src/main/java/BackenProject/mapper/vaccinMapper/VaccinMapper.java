package BackenProject.mapper.vaccinMapper;

import BackenProject.dto.VaccinDTO;
import BackenProject.model.Vaccin;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VaccinMapper {
    public Vaccin asVaccin(VaccinDTO vaccinDTO){
        Vaccin vaccin=new Vaccin();
        BeanUtils.copyProperties(vaccinDTO,vaccin);
        return vaccin;
    }

    public VaccinDTO asVaccinDTO(Vaccin vaccin){
        VaccinDTO vaccinDTO=new VaccinDTO();
        BeanUtils.copyProperties(vaccin,vaccinDTO);
        return vaccinDTO;
    }
}
