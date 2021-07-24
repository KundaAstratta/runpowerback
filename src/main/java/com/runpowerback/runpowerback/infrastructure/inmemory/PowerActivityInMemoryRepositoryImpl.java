package com.runpowerback.runpowerback.infrastructure.inmemory;

import com.runpowerback.runpowerback.domaine.entity.PowerActivityPointOf;
import com.runpowerback.runpowerback.domaine.repository.PowerActivityRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Profile({"in-memory"})
@Repository
public class PowerActivityInMemoryRepositoryImpl implements PowerActivityRepository {

    List<PowerActivityPointOf> powerActivityPointOfList = new ArrayList<>();

    @Override
    public Long save(PowerActivityPointOf powerActivity) {
       powerActivityPointOfList.add(powerActivity);
       return powerActivityPointOfList.get(powerActivityPointOfList.size()-1).getId();
    }

    @Override
    public List<PowerActivityPointOf> findAll() {
        return powerActivityPointOfList.stream().collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        powerActivityPointOfList.clear();
    }

    @Override
    public List<PowerActivityPointOf> findOnePowerActivity(Long idathlete, Long idpoweractivity) {
        return powerActivityPointOfList.stream()
                .filter(index -> index.getIdathlete().equals(idathlete) && index.getIdpoweractivity().equals(idpoweractivity))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOnePowerActivity(Long idathlete, Long idpoweractivity) {
        List<PowerActivityPointOf> powerActivityPointOfFoundList = powerActivityPointOfList.stream()
                .filter(index -> index.getIdathlete() == idathlete && index.getIdpoweractivity()==idpoweractivity)
                .collect(Collectors.toList());

        powerActivityPointOfFoundList.forEach(powerActivityPointOfFound -> powerActivityPointOfList.remove(powerActivityPointOfFound));
    }

    @Override
    public Long findMaxIdPowerActivity(Long idathlete) {

        List<PowerActivityPointOf> sortedList = powerActivityPointOfList.stream()
                .filter(index -> index.getIdathlete().equals(idathlete))
                .sorted(Comparator.comparing(PowerActivityPointOf::getIdpoweractivity))
                .collect(Collectors.toList());

        return sortedList.size() != 0 ? sortedList.get(sortedList.size() - 1).getIdpoweractivity() : Long.valueOf(0L);
    }


}
