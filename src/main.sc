require: slotfilling/slotFilling.sc
  module = sys.zb-common

require: functions.js

theme: /

    state: Start
        q!: $regex</start>
        a: Молви друг и войди!
    
        state: Melon
            q: melon
            a: Перед тобой три коридора, в какой пойдешь?
            
            state: Left
                q: * * лев * *
                a: тебя съел дракон.
            
            state: Right
                q: направо
                a: вы идете в далекое путешествие в горы,
                   чтобы уничтожить кольцо всевластия.
                
            state: Strait
                q: Прям
                a: Перед вами сундук. Что сделаете?
                
                state: Open
                    q: * ([~сломать]|[~открыть]|[~вскрыть]) *
                    a: В сундуке монеты, ровно {{getRandomInt(10)}} червонца.
            
        state: NoMelon
            event: noMatch
            a: На эльфийском, друг
        
    state: NoMatch
        event!: noMatch
        a: Я не говорю по русски, я разговариваю по эльфийски
