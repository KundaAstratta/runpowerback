package com.runpowerback.runpowerback.application.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.runpowerback.runpowerback.domaine.entity.PowerActivityFireBase;
import com.runpowerback.runpowerback.domaine.entity.PredictionFireBase;

import com.runpowerback.runpowerback.domaine.entity.StatisticsActivityFireBase;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FireBaseService {

    public static final String COL_PREDICTIONS="predictions";

    public static final String COL_STATISTICS="statistics";

    public static final String COL_POWERACTIVITIES="poweractivities";

    public String savePredictionDetailsToFirebase(PredictionFireBase predictionFireBase)
            throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture =
                dbFirestore.collection(COL_PREDICTIONS).document(predictionFireBase.getPredictionFireBaseIdentity()).set(predictionFireBase);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String saveStatisticsDetailsToFirebase(StatisticsActivityFireBase statisticsActivityFireBase)
        throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture =
                dbFirestore.collection(COL_STATISTICS).document(statisticsActivityFireBase.getStatisticActivityFireBaseIdentity()).set(statisticsActivityFireBase);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String savePowerActivityDetailsToFireBase(PowerActivityFireBase powerActivityFireBase)
        throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsAPiFuture =
                dbFirestore.collection(COL_POWERACTIVITIES).document(powerActivityFireBase.getPowerActivtyFireBaseIdentity()).set(powerActivityFireBase);
        return collectionsAPiFuture.get().getUpdateTime().toString();
    }
    
}
