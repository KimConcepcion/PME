package dk.pme.kim.challenge4

import java.util.*
import kotlin.collections.ArrayList

data class Owner(val login : String)
data class Repo (var name : String, var owner : Owner, var html_url : String,
                 var updated_at : String, var stargazers_count : Int)
data class Repos(var reposList : ArrayList<Repo>)