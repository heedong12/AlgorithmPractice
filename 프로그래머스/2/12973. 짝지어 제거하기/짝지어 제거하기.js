function solution(s)
{
    const stack = []
  
  for (const alpha of s) {
      if(stack.length>0 && stack[stack.length-1]===alpha){
          stack.pop()
      } else {
          stack.push(alpha)
      }
  }
      return stack.length===0 ? 1 : 0
}