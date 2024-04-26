package BackenProject.service.centreService;

import BackenProject.dto.CentreDTO;
import BackenProject.mapper.centreMapper.CentreMapper;
import BackenProject.model.Centre;
import BackenProject.repository.CentreRepository;
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
public class CentreServiceImpl implements CentreService{

  private  CentreMapper centreMapper;
  private CentreRepository centreRepository;


    @Override
    public List<CentreDTO> getAllCentre()  {
        List<Centre> centreList = centreRepository.findAll();
        List<CentreDTO> centreDTOList=  centreList.stream().map(centre -> centreMapper.asCentreDTO(centre))
                .collect(Collectors.toList());
        return centreDTOList;
    }

    @Override
    public CentreDTO saveCentreVaccination(CentreDTO centreDTO) {
        return centreMapper.asCentreDTO(centreRepository
                .save(centreMapper.asCentre(centreDTO)));
    }

    @Override
    public CentreDTO getCentreById(Long centreId)  {
        Centre centre = centreRepository.findById(centreId)
                .orElseThrow(() -> new EntityNotFoundException("Centre est introuvable"));
        return centreMapper.asCentreDTO(centre);
    }

    @Override
    public void deleteCentre(Long id) {
        Centre centre=centreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Centre with id {0}",id)));
        centreRepository.delete(centre);
    }

    @Override
    public CentreDTO updateCentre(CentreDTO centreDTO) {
        Centre centre= centreRepository.findById(centreDTO.getId()).                orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Centre with id {0}", centreDTO.getId())));

        return centreMapper.asCentreDTO(centreRepository.save(centre));
    }
}
