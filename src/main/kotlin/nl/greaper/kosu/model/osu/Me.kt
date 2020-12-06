package nl.greaper.kosu.model.osu

data class Me(
    val avatar_url: String,
    val country_code: String,
    val default_group: String,
    val id: Long,
    val is_active: Boolean,
    val is_bot: Boolean,
    val is_online: Boolean,
    val is_supporter: Boolean,
    val last_visit: String,
    val pm_friends_only: Boolean,
    val profile_colour: String,
    val username: String,
    val cover_url: String,
    val discord: String?,
    val has_supported: Boolean,
    val interests: String?,
    val join_date: String,
    val kudosu: Kudosu,
    val location: String?,
    val max_blocks: Int,
    val max_friends: Int,
    val occupation: String?,
    val playmode: Playmode,
    val playstyle: List<String>,
    val post_count: Int,
    val profile_order: List<String>,
    val skype: String?,
    val title: String?,
    val title_url: String?,
    val twitter: String?,
    val website: String?,
    val country: Country,
    val cover: Cover,
    val beatmap_playcounts_count: Int,
    val favourite_beatmapset_count: Int,
    val follower_count: Int,
    val graveyard_beatmapset_count: Int,
    val groups: List<Group>,
    val loved_beatmapset_count: Int,
    val monthly_playcounts: List<MonthlyCount>,
    val page: Page,
    val previous_usernames: List<String>,
    val ranked_and_approved_beatmapset_count: Int,
    val replays_watched_counts: List<MonthlyCount>,
    val scores_best_count: Int,
    val scores_first_count: Int,
    val scores_recent_count: Int,
    val statistics: Statistics,
    val support_level: Int,
    val unranked_beatmapset_count: Int,
    val user_achievements: String
) {
    data class Country(
        val code: String,
        val name: String
    )

    data class Cover(
        val custom_url: String?,
        val url: String,
        val id: String?
    )

    data class Kudosu(
        val total: Int,
        val available: Int
    )

    data class MonthlyCount(
        val start_date: String,
        val count: Int
    )

    data class Page(
        val html: String,
        val raw: String
    )

    data class Statistics(
        val level: Level,
        val pp: Float,
        val pp_rank: Int,
        val ranked_score: Int,
        val hit_accuracy: Float,
        val play_count: Int,
        val play_time: Int,
        val total_score: Int,
        val total_hits: Int,
        val maximum_combo: Int,
        val replays_watched_by_others: Int,
        val is_ranked: Boolean,
        val grade_counts: GradeCounts,
        val rank: Rank
    ) {
        data class Level(
            val current: Int,
            val progress: Int
        )

        data class GradeCounts(
            val ss: Int,
            val ssh: Int,
            val s: Int,
            val sh: Int,
            val a: Int
        )

        data class Rank(
            val global: Int,
            val country: Int
        )
    }
}