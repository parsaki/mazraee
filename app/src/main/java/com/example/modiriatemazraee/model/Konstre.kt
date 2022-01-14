package com.example.modiriatemazraee.model


class Konstre(val index:ArrayList<Konsantres>) {
        public fun get_price_of_0n_kilo(): Int {
            var total = 0F
            index.forEach {
                total += it.price * it.weight
            }
            total /= index.size
            return total.toInt()
        }

        fun get_pircent_iteam(position: Int): Float {
            var total = 0F
            index.forEach {
                total += it.weight
            }
            println("mas  4423: $total  $index[position].weight  ${(index[position].weight / total) * 100}")
            return (index[position].weight / total) * 100
        }


}