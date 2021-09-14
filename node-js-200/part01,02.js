// 053. 콜백함수
const sum = (a, b) => a + b;

const printResult = (result) => {
    console.log(`결과는 ${result}입니다.`);
}

// 콜백함수 : 특정 함수에 파라미터로 전달된 함수 (js에서 함수는 일급 객체)
// - 해당 함수가 실행될 때 호출됨
const calculationAndPrint = (calculationResult, callback) => {
    callback(calculationResult);
}

calculationAndPrint(sum(10, 20), printResult); // 결과는 30입니다.

// 094. 함수 return 
const returnFunction = () => (a, b) => a + b;
const plus = returnFunction();
// const plus = returnFunction; // [Function (anonymous)]
console.log(plus(10, 20));

// 101. closer
function grandParent(g1, g2) {
    const g3 = 3;
    return function parent(p1, p2) {
        const p3 = 33;
        return function child(c1, c2) {
            const c3 = 333;
            return g1 + g2 + g3 + p1 + p2 + p3 + c1 + c2 + c3;
        };
    };
}
// 클로저 : 내부 함수가 참조하는 외부함수의 지역변수가
// - 외부 함수가 리턴된 이후에도 유효성이 유지될 때-> 내부 함수가 클로저
// - 클로저는 자신의 코드 블록 내 정의된 변수, 외부 함수 내부에 정의된 변수, 전역 변수
// 3가지 스코프 체인을 가진다.
// - 클로저는 외부 함수 값이 아닌 참조를 저장하는 식으로 동작
// - 클로저가 호출되기 전 외부 함수 값이 변경되면 변경된 값을 내놓게 됨
const parentFunction = grandParent(1, 2);
const childFunction = parentFunction(11, 22);
console.log(childFunction(111, 222));

// 103. 커링
// 커링 : 여러 개의 파라미터 중 일부만 필요로 하는 함수를 만드는 기법
// 비동기 실행이 많은 node.js에서 return 값이 없는 대신 callback을 인자로 넘겨 사용
const add = x => y => x + y;
const add10 = add(10); // const add10 = y => 10+y;

console.log(add10(20)); // 30
console.log(add(10)(20)); // 30