class Node {
    constructor(value, prev = null, next = null) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}

function solution(n, k, cmd) {
    const table = new Array(n).fill(true);
    const nodes = [...new Array(n)].map((_, i) => new Node(i));
    const trash = [];
    let index = nodes[k];

    // 연결리스트 구조 초기화
    for (let i = 0; i < n; i++) {
        if (i > 0) nodes[i].prev = nodes[i - 1];
        if (i < n - 1) nodes[i].next = nodes[i + 1];
    }

    for (let command of cmd) {
        let [c, num] = command.split(' ');
        num = parseInt(num);

        switch (c) {
            case 'U':
                for (let i = 0; i < num; i++) {
                    if (index.prev) {
                        index = index.prev;
                    }
                }
                break;
            case 'D':
                for (let i = 0; i < num; i++) {
                    if (index.next) {
                        index = index.next;
                    }
                }
                break;
            case 'C':
                table[index.value] = false;
                trash.push(index);

                // 노드 삭제 처리
                if (index.next === null) {  // 마지막 노드 삭제
                    index = index.prev;
                    index.next = null;
                } else if (index.prev === null) {  // 첫 번째 노드 삭제
                    index = index.next;
                    index.prev = null;
                } else {  // 중간 노드 삭제
                    index.prev.next = index.next;
                    index.next.prev = index.prev;
                    index = index.next;
                }
                break;
            case 'Z':
                let restoredNode = trash.pop();
                table[restoredNode.value] = true;

                if (restoredNode.prev) restoredNode.prev.next = restoredNode;
                if (restoredNode.next) restoredNode.next.prev = restoredNode;
                break;
        }
    }

    return table.map(item => item ? 'O' : 'X').join('');
}
