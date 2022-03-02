package com.wiloke.shopify.connection.services.impl;

import com.wiloke.shopify.connection.repositories.skeleton.CheckoutSkeleton;
import com.wiloke.shopify.connection.repositories.skeleton.CommandSkeleton;
import com.wiloke.shopify.connection.services.ShopifyServiceFakeAble;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
@Data
@Service(value = "CommentServiceImpl")
public class CommentServiceImpl implements ShopifyServiceFakeAble {
    @Autowired
    private CommandSkeleton commandSkeleton;

    @Override
    public Object getData() throws Exception {
        HashMap<String, Object> comment = new HashMap<>();
        var listComments = new ArrayList<>();
        listComments.add(commandSkeleton.getComments());
        listComments.add(commandSkeleton.getComments());
        listComments.add(commandSkeleton.getComments());
        listComments.add(commandSkeleton.getComments());
        listComments.add(commandSkeleton.getComments());
        listComments.add(commandSkeleton.getComments());
        listComments.add(commandSkeleton.getComments());
        listComments.add(commandSkeleton.getComments());
        listComments.add(commandSkeleton.getComments());
        listComments.add(commandSkeleton.getComments());
        comment.put("comments", listComments);
        return comment;
    }
}
