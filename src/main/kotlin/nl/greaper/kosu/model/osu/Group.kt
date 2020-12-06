package nl.greaper.kosu.model.osu

data class Group(
    val id: Long,
    val identifier: String,
    val name: String,
    val short_name: String,
    val description: String,
    val colour: String,
    val playmodes: List<Playmode>
)