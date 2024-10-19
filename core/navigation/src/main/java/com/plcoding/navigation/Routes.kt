package com.plcoding.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object ScreenA: Route

    @Serializable
    data object ScreenB: Route

    @Serializable
    data object ScreenC: Route
}