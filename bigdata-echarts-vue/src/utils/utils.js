
// 折线图

//取出data下各个map集合，转为数组
export function mapToArray( data){
    const fieldNames = Object.keys(data[0]);
    const result = {};
    fieldNames.forEach(fieldName => {
    result[fieldName] = data.map(item => item[fieldName]);
    });
   return result;

}

//// 将 Proxy 对象转为数组
export function proxyToArray(data){
    return  Array.from(data);
}


// 饼状图

//取出data下各个map集合，转为value与name的map集合
export function mapToValueMap(data){

        const transformedData = data.map(item => {
          return {
            name: item.primaryClassification,
            value: item.patentCount
          };
        });

        return transformedData;
}

//取出data下各个map集合，转为value与name的map集合
export function mapToValueMap4(data){

    const transformedData = data.map(item => {
      return {
        name: item.legalStatus,
        value: item.patentCount
      };
    });

    return transformedData;
}


//取出data下各个map集合，转为value与name的map集合
export function mapToValueMap5(data){

  const transformedData = data.map(item => {
    return {
      name: item.citedPatentName,
      value: item.citationCount
    };
  });

  return transformedData;
}

//取出data下各个map集合，转为value与name的map集合
export function mapToValueMap6(data){

  const transformedData = data.map(item => {
    return {
      name: item.citedFamilyToFamilyReference,
      value: item.referenceCount
    };
  });

  return transformedData;
}

//取出data下各个map集合，转为value与name的map集合
export function mapToValueMap7(data){

  const transformedData = data.map(item => {
    return [item.subjectCode, item.patentCount];
  });

  return transformedData;
}


//取出data下各个map集合，转为value与name的map集合
export function mapToValueMap11(data){

  const transformedData = data.map(item => {
    return {
      name: item.claimsCountCategory,
      value: item.patentCount
    };
  });

  return transformedData;
}


export function mapToValueMap12(data){

  const transformedData = data.map(item => {
    return [item.citationCount, item.patentCount];
  });

  return transformedData;
}

