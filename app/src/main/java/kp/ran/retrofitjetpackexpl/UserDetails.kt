package kp.ran.retrofitjetpackexpl

data class UserDetails(
    val data: List<Data>?=null,
    val page: Int=0,
    val per_page: Int=0,
    val support: Support? =null,
    val total: Int=0,
    val total_pages: Int=0
)