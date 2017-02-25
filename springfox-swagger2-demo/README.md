# A demo for generating HTML or PDF
环境配置：SpringBoot、SpringFox、Swagger2Markup、Asciidoctor 和 Maven


使用 `Swagger2Markup` 将 `Swagger.json` 转换成 `Markdown`:
``` java
Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                    .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                    .withOutputLanguage(Language.ZH)
                    .withPathsGroupedBy(GroupBy.TAGS)
                    .build();

Swagger2MarkupConverter converter = Swagger2MarkupConverter.from(localSwaggerFile).withConfig(config).build();
converter.toFile(outputFile);
```
下面就是转换后的 `Markdown`
----------------------------------------------------------------------

# Swagger Petstore


<a name="overview"></a>
## 概观
Petstore API Description


### 版本信息
*版本* : 1.0.0


### 联系方式
*名字* : leongfeng
*邮箱* : leongfeng@163.com


### 许可信息
*许可证* : Apache 2.0
*许可网址* : http://www.apache.org/licenses/LICENSE-2.0.html
*服务条款* : null


### URI scheme
*域名* : localhost
*基础路径* : /


### 标签

* Index : Index operation
* Pets : Operations about pets




<a name="paths"></a>
## 资源

<a name="index_resource"></a>
### Index
Index operation


<a name="indexusingget"></a>
#### index
```
GET /
```


##### 响应

|HTTP代码|说明|架构|
|---|---|---|
|**200**|OK|string|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


<a name="pets_resource"></a>
### Pets
Operations about pets


<a name="addpetusingpost"></a>
#### Add a new pet to the store
```
POST /pets
```


##### 参数

|类型|名称|说明|架构|
|---|---|---|---|
|**Body**|**pet**  <br>*必填*|Pet object that needs to be added to the store|[Pet](#pet)|


##### 响应

|HTTP代码|说明|架构|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|
|**405**|Invalid input|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


<a name="updatepetusingput"></a>
#### Update an existing pet
```
PUT /pets
```


##### 参数

|类型|名称|说明|架构|
|---|---|---|---|
|**Body**|**pet**  <br>*必填*|Pet object that needs to be added to the store|[Pet](#pet)|


##### 响应

|HTTP代码|说明|架构|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**400**|Invalid ID supplied|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Pet not found|无内容|
|**405**|Validation exception|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### 安全

|类型|名称|作用域|
|---|---|---|
|**未知**|**[petstore_auth](#petstore_auth)**|write_pets,read_pets|


<a name="getpetbyidusingget"></a>
#### find a pet by ID
```
GET /pets/{petId}
```


##### 说明
Returns a pet when ID < 10. ID > 10 or nonintegers will simulate API error conditions


##### 参数

|类型|名称|说明|架构|默认列|
|---|---|---|---|---|
|**Path**|**petId**  <br>*必填*|ID of pet that needs to be fetched|integer (int64)|`1`|


##### 响应

|HTTP代码|说明|架构|
|---|---|---|
|**200**|OK|[Pet](#pet)|
|**400**|Invalid ID supplied|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Pet not found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


<a name="deletepetbyidusingdelete"></a>
#### delte a pet by ID
```
DELETE /pets/{petId}
```


##### 说明
Delete a pet from the store


##### 参数

|类型|名称|说明|架构|默认列|
|---|---|---|---|---|
|**Path**|**petId**  <br>*必填*|ID of pet that needs to be fetched|integer (int64)|`1`|


##### 响应

|HTTP代码|说明|架构|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`




<a name="definitions"></a>
## 定义

<a name="category"></a>
### Category

|名称|架构|
|---|---|
|**id**  <br>*必填*|integer (int64)|
|**name**  <br>*必填*|string|


<a name="pet"></a>
### Pet

|名称|说明|架构|
|---|---|---|
|**category**  <br>*可选*||[Category](#category)|
|**id**  <br>*可选*||integer (int64)|
|**name**  <br>*可选*||string|
|**photoUrls**  <br>*可选*||< string > array|
|**status**  <br>*可选*|pet status in the store|enum (available, pending, sold)|
|**tags**  <br>*可选*||< [Tag](#tag) > array|


<a name="tag"></a>
### Tag

|名称|架构|
|---|---|
|**id**  <br>*可选*|integer (int64)|
|**name**  <br>*可选*|string|





