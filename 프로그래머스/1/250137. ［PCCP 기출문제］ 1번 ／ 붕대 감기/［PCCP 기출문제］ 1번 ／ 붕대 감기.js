function solution(bandage, health, attacks) {
    const [bandageTime, recovery, addRecovery] = bandage
    let maxHealth = health
    let curTime = 0

    for(const attack of attacks){
        const [attackTime, damage] = attack
        
        if(attackTime-curTime > 1) {
          health += Math.floor((attackTime-curTime-1)/bandageTime)*addRecovery + (attackTime-curTime-1) * recovery
        }
 
        health = health >= maxHealth ? maxHealth : health 

        health -= damage
        curTime = attackTime
        
        if(health <= 0) return -1;
    }
    
    return health;
}
