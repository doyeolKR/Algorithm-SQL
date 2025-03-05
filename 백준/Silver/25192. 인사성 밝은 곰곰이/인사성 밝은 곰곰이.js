const [chattingCount, ...chattingLog] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .split("\n")
  .map((value) => value.trim());

let set = new Set();

let answer = 0;

for (let i = 0; i < chattingCount; i++) {
  if (chattingLog[i] === "ENTER") {
    answer += set.size;
    set.clear();
    continue;
  }

  set.add(chattingLog[i]);
}

answer += set.size;

console.log(answer);