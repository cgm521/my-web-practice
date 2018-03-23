[参考](https://blog.csdn.net/u012129558/article/details/78423511) 


##　微信授权


- 1、[/login](/login)
    拼接APPID和callBack到微信的固定URL中，请求URL

- 2、[/callBack](/callBack)
    微信请求callBack接口，获取到code，用code、APPID、APPSECRET拼接获取token的链接，请求URL

- 3、获取返回数据里的accessToken、openid，用于获取用户的信息


## sendURL

get与post方式发送请求，请求URL