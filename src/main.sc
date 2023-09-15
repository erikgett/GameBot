require: slotfilling/slotFilling.sc
  module = sys.zb-common

require: functions.js

theme: /
    state: Start
        q!: $regex</start>
        a: Молви друг и войди!
    
        state: Melon
            q: * (melon|мелон) *
            a: Перед тобой три коридора, в какой пойдешь?
            
            state: Left
                q: * * лев * *
                a: тебя съел дракон. Начать с начала?
                    state: GoTostart
                        go: /Start/Melon
            
            state: Right
                q: направо
                a: вы идете в далекое путешествие в горы,
                   чтобы уничтожить кольцо всевластия.
                
            state: Strait
                q: Прям
                a: Перед вами сундук. Что сделаете?
                
                state: Open
                    q: * (~сломать|~открывать|~вскрывать) *
                    script:
                        $temp.count = 0
                        $temp.count = $temp.count + getRandomInt(10)
                    a: В сундуке монеты, ровно {{$temp.count}} червонца. Начать сначала?
                    state: GoTostart
                        q: да
                        go!: /Start
            
        state: NoMelon
            event: noMatch
            a: На эльфийском, друг
        
    state: NoMatch
        event!: noMatch
        a: Я не говорю по русски, я разговариваю по эльфийски
