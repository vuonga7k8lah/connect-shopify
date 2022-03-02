package com.wiloke.shopify.connection.dto.shopify;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionAllTagsDTO {
    private CollectionRuleDTO[] rulesDTO;

    public void setTags(CollectionRuleDTO[] rulesDTO) {
        this.rulesDTO = rulesDTO;
    }

    public Set<String> getTags() {
        return Arrays.stream(this.rulesDTO).map(CollectionRuleDTO::getCondition).collect(Collectors.toSet());

        //        return Arrays.stream(this.getNode().getRuleSet().getRules()).map(CollectionRuleDTO::getCondition).toArray(String[]::new);
//        return Arrays.stream(this.getNode().getRuleSet().getRules()).map(CollectionRuleDTO::getCondition).toArray(String[]::new);
//        return Arrays.stream(this.all_tags.getRuleSet().getRules()).flatMap(CollectionRuleDTO::getCondition).toArray();
    }
}
