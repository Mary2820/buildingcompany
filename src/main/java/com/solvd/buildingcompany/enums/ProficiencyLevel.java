package com.solvd.buildingcompany.enums;

public enum ProficiencyLevel {
    JUNIOR("Basic understanding of core concepts", 1),
    MIDDLE("Proficient in handling tasks independently", 2),
    SENIOR("Advanced expertise with leadership capabilities", 3),
    EXPERT("Master-level knowledge and strategic decision-making", 4);

    private final String requirement;
    private final int rank;

    ProficiencyLevel(String requirement, int rank) {
        this.requirement = requirement;
        this.rank = rank;
    }

    public String getRequirement() {
        return requirement;
    }

    public int getRank() {
        return rank;
    }
}
