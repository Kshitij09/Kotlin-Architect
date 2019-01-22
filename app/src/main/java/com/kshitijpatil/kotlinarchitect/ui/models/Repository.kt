package com.kshitijpatil.kotlinarchitect.ui.models

class Repository(
    var repositoryName: String,
    var repositoryOwner: String,
    var hasIssues: Boolean = false,
    var stars: Int = 0
)