require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Молви друг и войди!
    
        state: Melon
            q: melon
            a: Перед тобой три коридора, в какой пойдешь?
        
    state: NoMatch
        event!: noMatch
        a: Я не говорю по русски, я разговариваю по эльфийски
