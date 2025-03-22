package rps_Souls;

public enum Move {
    SWORD, MAGIC, SHIELD, PYROMANCY, ESTUS_FLASK;

    public boolean beats(Move opponent) {
        return switch (this) {
            case SWORD -> opponent == Move.PYROMANCY || opponent == Move.ESTUS_FLASK;
            case MAGIC -> opponent == Move.SWORD || opponent == Move.ESTUS_FLASK;
            case SHIELD -> opponent == Move.SWORD || opponent == Move.MAGIC;
            case PYROMANCY -> opponent == Move.SHIELD || opponent == Move.MAGIC;
            case ESTUS_FLASK -> opponent == Move.SHIELD || opponent == Move.PYROMANCY;
        };
    }
}
