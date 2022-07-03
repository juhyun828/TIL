// async가 아닌 함수에서 async 함수 호출하기
async function wait() {
    await new Promise(resolve => setTimeout(resolve, 1000));
    return 10;
}

function fun() {
    // async wait()를 호출하고 그 결과인 10을 얻을 때까지 기다리려면 어떻게 해야 할까요?
    // f는 일반 함수이기 때문에 여기선 'await'를 사용할 수 없다는 점에 주의하세요!

    // let res = await wait(); => 불가능

    // async 함수를 호출하면 프라미스가 반환되므로, .then을 붙이면 됩니다.
    wait().then(result => console.log("result : " + result));
    // result : 10
}

fun();

// 출처 : https://ko.javascript.info/async-await#ref-1346