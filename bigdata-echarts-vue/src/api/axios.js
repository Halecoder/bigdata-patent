import axios from 'axios';
// import { showMessage } from "./status";   // 引入状态码文件
import { ElMessage } from 'element-plus'  // 引入el 提示框，这个项目里用什么组件库这里引什么

// const service = axios.create({
//   baseURL: import.meta.env.VITE_APP_BASE_API, // url = base url + request url
//   // withCredentials: true, // send cookies when cross-domain requests
//   timeout: 30000 // request timeout
// })

axios.defaults.baseURL = "http://localhost:8080" ;// 配置axios请求的地址
axios.defaults.timeout = 30000; // 请求超时时间
axios.defaults.withCredentials = true; // 允许携带cookie


axios.interceptors.request.use(
  config => {
  // 配置请求头
    config.headers = {
      //'Content-Type':'application/x-www-form-urlencoded',   // 传参方式表单
      'Content-Type':'application/json;charset=UTF-8',        // 传参方式json
    };
    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

//http response 拦截器
axios.interceptors.response.use(
  response => {
    return response;
  },
  error => {
    const {response} = error;
    if (response) {
      // 请求已发出，但是不在2xx的范围
      // showMessage(response.status);           // 传入响应码，匹配响应码对应信息
      return Promise.reject(response.data);
    } else {
      ElMessage.warning('网络连接异常,请稍后再试!');
    }
  }
);

// 封装 GET POST 请求并导出
export function request(url='',params={},type='POST'){
//设置 url params type 的默认值
return new Promise((resolve,reject)=>{
  let promise
  if( type.toUpperCase()==='GET' ){
    promise = axios({
      url,
      params
    })
  }else if( type.toUpperCase()=== 'POST' ){
    promise = axios({
      method:'POST',
      url,
      data:params
    })
  }
  //处理返回
  promise.then(res=>{
    resolve(res)
  }).catch(err=>{
    reject(err)
  })
})
}
