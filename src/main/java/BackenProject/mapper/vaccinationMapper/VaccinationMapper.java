package BackenProject.mapper.vaccinationMapper;

import BackenProject.dto.VaccinationDTO;
import BackenProject.mapper.carnetMapper.CarnetMapper;
import BackenProject.mapper.consultationMapper.ConsultationMapper;
import BackenProject.mapper.userMapper.UserMapper;
import BackenProject.mapper.vaccinMapper.VaccinMapper;
import BackenProject.model.Vaccination;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VaccinationMapper {
    private UserMapper userMapper;

    private CarnetMapper carnetMapper;

    private VaccinMapper vaccinMapper;

    private ConsultationMapper consultationMapper;

    public VaccinationDTO asVaccinationDTO(Vaccination vaccination){
        VaccinationDTO vaccinationDTO=new VaccinationDTO();
        BeanUtils.copyProperties(vaccination,vaccinationDTO);
        vaccinationDTO.setCarnetDTO(carnetMapper.asCarnetDTO(vaccination.getCarnet()));
        vaccinationDTO.setVaccinDTO(vaccinMapper.asVaccinDTO(vaccination.getVaccin()));
        vaccinationDTO.setMedcinDTO(userMapper.asUserDTO(vaccination.getMedcin()));
        vaccinationDTO.setConsultationDTO(consultationMapper.asConsultationDTO(vaccination.getConsultation()));
        return vaccinationDTO;
    }


    public Vaccination asVaccination(VaccinationDTO vaccinationDTO){
        Vaccination vaccination=new Vaccination();
        BeanUtils.copyProperties(vaccinationDTO,vaccination);
        vaccination.setVaccin(vaccinMapper.asVaccin(vaccinationDTO.getVaccinDTO()));
        vaccination.setCarnet(carnetMapper.asCarnet(vaccinationDTO.getCarnetDTO()));
        vaccination.setMedcin(userMapper.asUser(vaccinationDTO.getMedcinDTO()));
        vaccination.setConsultation(consultationMapper.asConsultation(vaccinationDTO.getConsultationDTO()));
        return vaccination;
    }
}
