package com.runpowerback.runpowerback.domaine.exception;

import java.util.HashSet;
import java.util.Set;

public class MyProjectException500 extends RuntimeException {
    private Set<String> codeErreurs = new HashSet<>();

    public MyProjectException500(String codeErreur) {
        this.codeErreurs.add(codeErreur);
    }

    public MyProjectException500(Set<String> codeErreurs) {
        this.codeErreurs = codeErreurs;
    }

    public Set<String> getCodeErreurs() {
        return codeErreurs;
    }
}