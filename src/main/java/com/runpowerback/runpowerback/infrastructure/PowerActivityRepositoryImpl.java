package com.runpowerback.runpowerback.infrastructure;

import com.runpowerback.runpowerback.domaine.PowerActivity;
import com.runpowerback.runpowerback.domaine.PowerActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PowerActivityRepositoryImpl implements PowerActivityRepository {

    @Autowired
    PowerActivityDAO powerActivityDAO;

    @Override
    public Long save(PowerActivity powerActivity) {
      //  PowerActivityJPA powerActivityJPA = powerActivityDAO.save(new PowerActivity(powerActivity));
       this.powerActivityDAO.save(powerActivity);
       return powerActivity.getId();
    }

    @Override
    public List<PowerActivity> findAll() {
   //     return this.powerActivityDAO.findByOrderByIdAsc().stream().map(PowerActivityJPA::toPowerActivity).collect(Collectors.toList());
        return this.powerActivityDAO.findByOrderByIdAsc().stream().collect(Collectors.toList());

    }

    @Override
    public void deleteAll() {
        powerActivityDAO.deleteAll();
    }

    @Override
    public void deleteOnePowerActivity(Long idathlete, Long idpoweractivity) {
        powerActivityDAO.deleteOnePowerActivity(idathlete, idpoweractivity);
    }

    @Override
    public List<PowerActivity> findOnePowerActivity(Long idathlete, Long idpoweractivity) {
      //  return this.powerActivityDAO.findOnePowerActivity(idathlete,idpoweractivity).stream().map(PowerActivityJPA::toPowerActivity).collect(Collectors.toList());
        return this.powerActivityDAO.findOnePowerActivity(idathlete,idpoweractivity).stream().collect(Collectors.toList());

    }

}
