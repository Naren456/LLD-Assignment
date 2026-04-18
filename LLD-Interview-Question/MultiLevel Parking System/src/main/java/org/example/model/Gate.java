package org.example.model;

public class Gate {
    private String gateId;
    private int levelNumber;

    public Gate(String gateId, int levelNumber) {
        this.gateId = gateId;
        this.levelNumber = levelNumber;
    }

    public String getGateId() {
        return gateId;
    }

    public int getLevelNumber() {
        return levelNumber;
    }
}
