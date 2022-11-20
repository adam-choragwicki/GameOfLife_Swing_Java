package main;

public enum EvolutionSpeedLevel
{
    LEVEL_1(1),
    LEVEL_2(2),
    LEVEL_3(3),
    LEVEL_4(4),
    LEVEL_5(5),
    LEVEL_6(6),
    LEVEL_7(7),
    LEVEL_8(8),
    LEVEL_9(9),
    LEVEL_10(10);

    EvolutionSpeedLevel(int numericValue)
    {
        this.numericValue = numericValue;
    }

    public int getNumericValue()
    {
        return numericValue;
    }

    private final int numericValue;
}
