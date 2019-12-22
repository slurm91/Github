package home.vzhilko.domain.base.network

const val GITHUB_URL = "https://github.com/"
const val GITHUB_API_URL = "https://api.github.com/"

const val OAUTH_CODE_KEY = "code"

const val OAUTH_CLIENT_ID_KEY: String = "client_id"
const val OAUTH_CLIENT_ID: String = "281fe2b5a1e98041c4e9"

const val OAUTH_CLIENT_SECRET_KEY: String = "client_secret"
const val OAUTH_CLIENT_SECRET: String = "1aacdca4d3c0cf103f797c69ca0f90bb8f695e41"

const val OAUTH_SCOPE_KEY: String = "scope"
const val OAUTH_REPO_SCOPE: String = "repo"
const val OAUTH_USER_SCOPE: String = "user"

const val OAUTH_CALLBACK_URL_KEY: String = "redirect_uri"
const val OAUTH_CALLBACK_URL: String = "http://example.com/oauth/callback"

const val OAUTH_AUTHORIZATION_URL: String = "${GITHUB_URL}login/oauth/authorize" +
        "?$OAUTH_CLIENT_ID_KEY=$OAUTH_CLIENT_ID" +
        "&$OAUTH_SCOPE_KEY=$OAUTH_REPO_SCOPE" +
        "&$OAUTH_CALLBACK_URL_KEY=$OAUTH_CALLBACK_URL"

