package com.akobot.repository;

import com.akobot.domain.IntentDTO;
import com.akobot.domain.tables.EtcEntity;
import com.akobot.domain.tables.PushLogPK;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EtcRepository {
    private final EntityManager em;

    public void save(EtcEntity etc){
        if (etc.getPks() == null){
            em.persist(etc);
        } else{
            em.merge(etc);
        }
    }

    public IntentDTO findOne(int school_key, String field, String document){
        PushLogPK pk = new PushLogPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setDocument(document);

        EtcEntity etcEntity = em.find(EtcEntity.class, pk);

        if(etcEntity != null) {
            IntentDTO intentDTO = new IntentDTO();
            intentDTO.setPks(etcEntity.getPks());
            intentDTO.setContent(etcEntity.getContent());
            intentDTO.setElseData(etcEntity.getElseData());
            intentDTO.setLevel(etcEntity.getLevel());

            return intentDTO;
        }

        return null;
    }
}
