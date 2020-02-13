package com.runpowerback.runpowerback.domaine.exception;

import java.util.HashSet;
import java.util.Set;

public class MyProjectException400 extends RuntimeException {
    private Set<String> codeErreurs = new HashSet<>();

    public MyProjectException400(String codeErreur) {
        this.codeErreurs.add(codeErreur);
    }

    public MyProjectException400(Set<String> codeErreurs) {
        this.codeErreurs = codeErreurs;
    }

    public Set<String> getCodeErreurs() {
        return codeErreurs;
    }
}

