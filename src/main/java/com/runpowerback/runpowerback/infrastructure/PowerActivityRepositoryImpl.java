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
        PowerActivityJPA powerActivityJPA = powerActivityDAO.save(new PowerActivityJPA(powerActivity));
        return powerActivityJPA.getId();
    }

    @Override
    public List<PowerActivity> findAll() {
        return this.powerActivityDAO.findByOrderByIdAsc().stream().map(PowerActivityJPA::toPowerActivity).collect(Collectors.toList());
    }

}
