package com.wiloke.shopify.connection.services.impl;

import com.wiloke.shopify.connection.dto.shopify.QueryCostDTO;


import com.wiloke.shopify.connection.dto.shopify.request.ArticleRequestDTO;
import com.wiloke.shopify.connection.dto.shopify.request.BlogRequestDTO;
import com.wiloke.shopify.connection.repositories.Shopify;
import com.wiloke.shopify.connection.repositories.query.ShopifyQueryable;
import com.wiloke.shopify.connection.repositories.skeleton.ArticleSkeleton;
import com.wiloke.shopify.connection.repositories.skeleton.BlogSkeleton;
import com.wiloke.shopify.connection.services.ShopifyServiceAble;
import com.wiloke.shopify.connection.utils.APIUtil;
import com.wiloke.shopify.connection.utils.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service(value = "BlogServiceImpl")
public class BlogServiceImpl implements ShopifyServiceAble<BlogRequestDTO> {
    @Autowired
    private Shopify shopify;

    @Autowired
    @Qualifier(value = "BlogQuery")
    private ShopifyQueryable shopQuery;
    @Autowired
    @Qualifier(value = "ArticleQuery")
    private ShopifyQueryable articleQuery;

    @Autowired
    @Qualifier(value = "ArticleServiceImpl")
    private ShopifyServiceAble<ArticleRequestDTO> articleService;

    private BlogSkeleton skeleton;


    private final String offlineToken = "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";

    @Override
    public QueryCostDTO getQueryCost() {
        return this.skeleton.getExtensions();
    }


    @Override
    public Object getData(BlogRequestDTO dtoRequestable) throws Exception {
        var blogSkeleton = new BlogSkeleton();
        var articleSkeleton = new ArticleSkeleton();
        this.skeleton = this.shopify
                .withOfflineToken(AccessToken.token)
                .withShopName(dtoRequestable.getShopName())
                .withPluckResponse("")
                .query(shopQuery, blogSkeleton);

        var formatBlog = Arrays.stream(skeleton.getBlogs()).map(blog -> {
            try {
                var articleID = blog.getId();
                var articleData = this.shopify
                        .withId(String.valueOf(articleID))
                        .withOfflineToken(this.offlineToken)
                        .withShopName(dtoRequestable.getShopName())
                        .withPluckResponse("")
                        .query(articleQuery, articleSkeleton);

                blog.setArticles(articleData.getArticles());
                var countArticle = Arrays.stream(articleData.getArticles()).count();
                blog.setArticles_count((int) countArticle);

            } catch (Exception e) {
                e.printStackTrace();
            }

            blog.setUrl("https://" + shopify.getShopName() + "/blogs/" + blog.getHandle());
            return blog;
        }).parallel().collect(Collectors.toList());

        HashMap<String, Object> blogs = new HashMap<>();
        blogs.put("blogs", formatBlog);
        return blogs;
    }
}
