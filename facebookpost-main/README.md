# Facebook API Testing

This repository contains a Postman collection for testing the Facebook Graph API, including fetching user profiles and posting status updates.

## Prerequisites
- A valid Facebook Developer Account
- A Facebook App with API access
- A valid `access_token` with the required permissions
- Postman installed on your system

## Getting Started

### 1. Import the Postman Collection
1. Open Postman.
2. Click on **Import**.
3. Select **Raw Text** and paste the JSON collection provided.
4. Click **Continue** and then **Import**.

### 2. Set Up Environment Variables
- Create a new environment in Postman.
- Add the variable `access_token` and set its value to a valid Facebook API token.

## API Endpoints

### 1. Get User Profile
- **Method:** `GET`
- **URL:** `https://graph.facebook.com/me?access_token={{access_token}}`
- **Response:** Returns the user profile details of the authenticated user.

### 2. Post a Status Update
- **Method:** `POST`
- **URL:** `https://graph.facebook.com/me/feed?access_token={{access_token}}`
- **Headers:**
  - `Content-Type: application/json`
- **Body:**
  ```json
  {
      "message": "Hello from Postman!"
  }
  ```
- **Response:** Posts a status update on the authenticated user's feed.

## Notes
- Ensure that your `access_token` has the necessary permissions (`public_profile` for getting user details, `publish_actions` for posting updates).
- The `access_token` may expire, requiring renewal.

## Troubleshooting
- If you receive a `(#200) Permissions error`, ensure your app has the necessary permissions granted.
- If `access_token` is invalid, regenerate it via the Facebook Developer Portal.
- Check for API rate limits if multiple requests fail.

## References
- [Facebook Graph API Documentation](https://developers.facebook.com/docs/graph-api/)

