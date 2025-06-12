

# 社区服务平台API文档

## 1. 用户认证

### 1.1 用户注册
`POST /api/auth/register`

**请求参数:**
```json
{
  "username": "string",
  "password": "string",
  "email": "string",
  "phone": "string"
}
```

**相应：**

```json
{
  "code": 200,
  "message": "注册成功",
  "data": {
    "user_id": 1,
    "username": "testuser"
  }
}
```

### 1.2 用户登录

```
POST /api/auth/login
```

**请求参数:**

```json
{
  "username": "string",
  "password": "string"
}
```

**响应:**

```json
{
  "code": 200,
  "message": "登录成功",
  "data": {
    "token": "jwt_token_string",
    "user_info": {
      "user_id": 1,
      "username": "testuser",
      "user_type": "customer"
    }
  }
}
```

## 2. 商品服务

### 2.1 获取商品列表

```
GET /api/products
```

**查询参数:**

- category_id: 分类ID
- page: 页码
- page_size: 每页数量
- sort: 排序方式(price_asc/price_desc/sales_desc)

**响应:**

```json
{
  "code": 200,
  "data": {
    "list": [
      {
        "product_id": 1,
        "name": "商品名称",
        "price": 99.99,
        "main_image": "url",
        "sales": 100
      }
    ],
    "total": 50
  }
}
```

### 2.2 获取商品详情

```
GET /api/products/{product_id}
```

**响应:**

```json
{
  "code": 200,
  "data": {
    "product_id": 1,
    "name": "商品名称",
    "description": "商品描述",
    "price": 99.99,
    "images": ["url1", "url2"],
    "stock": 100
  }
}
```

## 3. 订单服务

### 3.1 创建订单

```
POST /api/orders
```

**请求参数:**

```json
{
  "order_type": "product",
  "items": [
    {
      "product_id": 1,
      "quantity": 2
    }
  ],
  "address_id": 1
}
```

**响应:**

```json
{
  "code": 200,
  "data": {
    "order_id": "20230101123456",
    "total_amount": 199.98,
    "payment_amount": 199.98
  }
}
```

### 3.2 支付订单

```
POST /api/orders/{order_id}/pay
```

**请求参数:**

```json
{
  "payment_method": "wechat"
}
```

**响应:**

```json
{
  "code": 200,
  "data": {
    "payment_url": "wechat_pay_url"
  }
}
```

## 4. 社区服务

### 4.1 发布帖子

```
POST /api/posts
```

```json
{
  "title": "帖子标题",
  "content": "帖子内容"
}
```

```json
{
  "code": 200,
  "data": {
    "post_id": 1
  }
}
```

### 4.2 点赞帖子

```
POST /api/posts/{post_id}/like
```

**响应:**

```json
{
  "code": 200,
  "message": "操作成功"
}
```

## 5. 客服服务

### 5.1 发起客服会话

```
POST /api/customer-service/sessions
```

**响应:**

```json
{
  "code": 200,
  "data": {
    "session_id": 1
  }
}
```

### 5.2 发送客服消息

```
POST /api/customer-service/sessions/{session_id}/messages
```

**请求参数:**

```json
{
  "content": "消息内容"
}
```

**响应:**

```json
{
  "code": 200,
  "data": {
    "message_id": 1
  }
}
```

## 6. 售后服务

### 6.1 申请售后

```
POST /api/after-sales
```

**请求参数:**

```json
{
  "order_id": "20230101123456",
  "type": 1,
  "reason": "质量问题",
  "description": "详细描述",
  "images": ["url1", "url2"]
}
```

**响应:**

```json
{
  "code": 200,
  "data": {
    "after_sale_id": 1
  }
}
```

### 6.2 获取售后进度

```
GET /api/after-sales/{after_sale_id}
```

**响应:**

```json
{
  "code": 200,
  "data": {
    "status": 1,
    "logs": [
      {
        "action": "申请售后",
        "operator": "用户",
        "time": "2023-01-01 12:00:00"
      }
    ]
  }
}
```

## 错误码说明

| 错误码 | 说明       |
| :----- | :--------- |
| 200    | 成功       |
| 400    | 参数错误   |
| 401    | 未授权     |
| 403    | 禁止访问   |
| 404    | 资源不存在 |
| 500    | 服务器错误 |