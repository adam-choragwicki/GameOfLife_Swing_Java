package main;

import java.util.HashMap;

public class EvolutionSpeedManager
{
    public static EvolutionSpeedLevel convertEvolutionSpeedSliderValueToEvolutionSpeedLevelValue(int sliderValue)
    {
        for (EvolutionSpeedLevel evolutionSpeedLevel : EvolutionSpeedLevel.values())
        {
            if (evolutionSpeedLevel.getNumericValue() == sliderValue)
            {
                return evolutionSpeedLevel;
            }
        }

        throw new IllegalArgumentException("Unsupported evolution speed level slider value=" + sliderValue);
    }

    public static int convertEvolutionSpeedLevelValueToEvolutionDelayMs(EvolutionSpeedLevel evolutionSpeedLevel)
    {
        if (speedLevelToDelayMsMap.containsKey(evolutionSpeedLevel))
        {
            return speedLevelToDelayMsMap.get(evolutionSpeedLevel);
        }
        else
        {
            throw new RuntimeException("Unsupported speed level: " + evolutionSpeedLevel.getNumericValue());
        }
    }

    static final HashMap<EvolutionSpeedLevel, Integer> speedLevelToDelayMsMap;

    static
    {
        speedLevelToDelayMsMap = new HashMap<>();
        speedLevelToDelayMsMap.put(EvolutionSpeedLevel.LEVEL_1, 2560);
        speedLevelToDelayMsMap.put(EvolutionSpeedLevel.LEVEL_2, 1280);
        speedLevelToDelayMsMap.put(EvolutionSpeedLevel.LEVEL_3, 640);
        speedLevelToDelayMsMap.put(EvolutionSpeedLevel.LEVEL_4, 320);
        speedLevelToDelayMsMap.put(EvolutionSpeedLevel.LEVEL_5, 160);
        speedLevelToDelayMsMap.put(EvolutionSpeedLevel.LEVEL_6, 80);
        speedLevelToDelayMsMap.put(EvolutionSpeedLevel.LEVEL_7, 40);
        speedLevelToDelayMsMap.put(EvolutionSpeedLevel.LEVEL_8, 20);
        speedLevelToDelayMsMap.put(EvolutionSpeedLevel.LEVEL_9, 10);
        speedLevelToDelayMsMap.put(EvolutionSpeedLevel.LEVEL_10, 5);
    }
}
