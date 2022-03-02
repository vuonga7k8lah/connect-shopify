# Hiểu về luồng xử lý

## Client Request
Lưu ý: Mọi request cần có Bearer Token và X-Shopname như những app trước đã làm.

## Cấu trúc request 

http://localhost:8090/vge/v1/shop?pluck=name,domain

1. pluck: Là dữ liệu muốn phía client muốn trả về.

## Code Flow (Luồng code)

https://lucid.app/lucidchart/0557060e-217a-4399-86bb-9f5d395216ae/edit?invitationId=inv_9bd1d6a8-27c7-45fc-a980-c705a9088bf4

----
### dto 
Là thư mục định nghĩa kiểu dữ liệu trả về phía client.

Thư mục này đồng thời giúp cho việc Mapping Data với Shopify GraphQL.

Dưới folder DTO có các 3 nhóm files:

1. Dưới folder request: Có file ABCDTORequest extends DTORequestable => Đây là file quy định các thông tin bắn lên phía client
2. Dưới request là folder pluck: Quy định các thông tin của pluck. Các thông số tại pluck phải tuân thủ Pluck. 
3. Folder dưới dto -> shopify: Là Mapping Shopify Response.

----
### graphqlbuilder
Tự động render graphql query

Ví dụ:

dto -> shopify -> request -> pluck:

```java
import com.wiloke.shopify.connection.dto.shopify.request.pluck.InfoPluckable;

class ShopifyInfoDTO implements InfoPluckable {
    name("name", null, true),
    primaryDomain("primaryDomain", "url,host", false);

    private String field;
    private String subQuery;
    private Boolean isDefault;

    ShopInfoPluck(String field, String subQuery, boolean isDefault) {
        this.field = field;
        this.subQuery = subQuery;
        this.isDefault = isDefault;
    }
}
```
Ba tham số lần lượt là:
1. field
2. subQuery
3. isDefault: Nếu client không truyền pluck lúc query thì mặc định được sử dụng

=> Câu lệnh query được in ra 

```graphql
{
    shop {
        name,
        primaryDomain {
            url,
            host
        }
    }
}
```

Đây là đoạn code tại service. Ví dụ ShopServiceImpl

----
### repository
Tại Service, chúng ta truyền vào tham số query:
```java
@Override
public Object getData(ShopRequestDTO dtoRequestable) throws Exception {
    this.shopSkeleton = this.shopify
            .withOfflineToken(this.offlineToken)
            .withShopName(dtoRequestable.getShopName())
            .withPluckResponse(this.shopQueryBuilder.setRequest(dtoRequestable).build())
            .query(shopQuery, this.shopSkeleton);
    return shopSkeleton.getData();
}
```

query: Nhận vào 2 tham số:
1. QueryHandler: Ví dụ đang query lên Shop thì ShopQuery sẽ xử lý
2. SkeletonHandler: Dữ liệu trả về sẽ được ShopSkeleton xử lý. Phần này sẽ mapping lại với DTO