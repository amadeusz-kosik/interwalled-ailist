package me.kosik.interwalled.ailist.model;


public record AIListConfiguration(
        Integer maximumComponentsCount,
        Integer intervalsCountToCheckLookahead,
        Integer intervalsCountToTriggerExtraction,
        Integer minimumComponentSize,
        Boolean isInputDataSorted
) {

    final public static AIListConfiguration DEFAULT =
            new AIListConfiguration(10, 20, 10, 64, false);
}
