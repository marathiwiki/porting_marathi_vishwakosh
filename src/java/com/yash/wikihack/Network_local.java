package com.yash.wikihack;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Network_local {
	private static Map<String, String> cookies = new HashMap<String, String>(12);
	private static String url_server = "http://localhost:81/mediawiki/api.php?";

//	 private static String url_server="https://en.wikipedia.org/w/api.php?";
	public static String login(String username, String password) {
		// Create a new HttpClient and Post Header
		// HttpClient httpclient = new DefaultHttpClient();
		// HttpPost httppost = new HttpPost(
		// "https://en.wikipedia.org/w/api.php?action=login&format=json");

		String returnstr;
		try {
			StringBuilder buffer = new StringBuilder(500);
			// buffer.append("lgname=");
			// // buffer.append(URLEncoder.encode(username, "UTF-8"));
			// buffer.append(username);
			// buffer.append("lgdomain=mr");

			// Add your data
			// List<NameValuePair> nameValuePairs = new
			// ArrayList<NameValuePair>(2);
			// nameValuePairs.add(new BasicNameValuePair("lgname", username));
			// nameValuePairs.add(new BasicNameValuePair("lgpassword",
			// password));
			// httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			// Execute HTTP Post Request
			// HttpResponse response = httpclient.execute(httppost);
			// String responseBody = EntityUtils.toString(response.getEntity());
			// String responseBody =
			// post("https://en.wikipedia.org/w/api.php?action=login&format=json",
			// buffer.toString());
			String responseBody = post(
					url_server + "action=login&format=json&lgname="+username,
					buffer.toString());
			// //Log.d("dasfas", responseBody);
			System.out.println(responseBody);
			String lgtoken = null;
			JSONObject reader;
			JSONObject loginJSONObject;
			JSONObject tokenJSONObject;

			try {
				reader = new JSONObject(responseBody);
				loginJSONObject = reader.getJSONObject("login");
				lgtoken = loginJSONObject.getString("token");

			} catch (JSONException e) {
				e.printStackTrace();
				return null;
			}
			// nameValuePairs = new ArrayList<NameValuePair>(3);
			// nameValuePairs.add(new BasicNameValuePair("lgname", username));
			// nameValuePairs.add(new BasicNameValuePair("lgpassword",
			// password));
			// nameValuePairs.add(new BasicNameValuePair("lgtoken", lgtoken));
			// httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			// Execute HTTP Post Request
			// response = httpclient.execute(httppost);
			// buffer.append("&lgpassword=");
			// buffer.append(URLEncoder.encode(new String(password), "UTF-8"));
			// buffer.append("&lgtoken=");
			// buffer.append(URLEncoder.encode(lgtoken, "UTF-8"));
			String tst = url_server
					+ "action=login&format=json&lgname=" + username + "&lgtoken="
					+ lgtoken + "&lgpassword=" + password;
			responseBody = post(tst, buffer.toString());
			System.out.println(responseBody);
			buffer = null;
			// responseBody = EntityUtils.toString(response.getEntity());
			// //Log.d("dasfas", responseBody);
			String result;
			try {
				reader = new JSONObject(responseBody);
				loginJSONObject = reader.getJSONObject("login");
				result = loginJSONObject.getString("result");
			} catch (JSONException e) {
				e.printStackTrace();
				return null;
			}

			return result;

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return null;
	}

	/*
	 * public static String getEditToken(String title) { HttpClient httpclient =
	 * new DefaultHttpClient(); HttpPost httppost = new HttpPost(
	 * "https://en.wikipedia.org/w/api.php?action=query&format=json");
	 * 
	 * try { // Add your data List<NameValuePair> nameValuePairs = new
	 * ArrayList<NameValuePair>(1); nameValuePairs.add(new
	 * BasicNameValuePair("meta", "tokens")); httppost.setEntity(new
	 * UrlEncodedFormEntity(nameValuePairs));
	 * 
	 * // Execute HTTP Post Request HttpResponse response =
	 * httpclient.execute(httppost); String responseBody =
	 * EntityUtils.toString(response.getEntity()); // return responseBody;
	 * 
	 * String edittoken = null; String starttimestamp = null; JSONObject reader;
	 * JSONObject queryJSONObject; JSONObject pagesJSONObject; JSONObject
	 * minus1JSONObject;
	 * 
	 * try { ////Log.d(">>>>>>>>>>>>>>>>>>>>>>", responseBody); reader = new
	 * JSONObject(responseBody); queryJSONObject =
	 * reader.getJSONObject("query"); pagesJSONObject =
	 * reader.getJSONObject("pages"); // minus1JSONObject =
	 * reader.getJSONObject("-1"); //edittoken =
	 * minus1JSONObject.getString("csrftoken"); // starttimestamp =
	 * minus1JSONObject.getString("starttimestamp"); // return
	 * (edittoken+"@"+starttimestamp); String returnstr = edittoken + "@" +
	 * starttimestamp; return returnstr;
	 * 
	 * } catch (JSONException e) { e.printStackTrace(); return null; } } catch
	 * (ClientProtocolException e) { // TODO Auto-generated catch block } catch
	 * (IOException e) { // TODO Auto-generated catch block } return "WRONG"; }
	 */

	public static String getEditToken() {
		// HttpClient httpclient = new DefaultHttpClient();
		// HttpPost httppost = new HttpPost(
		// "https://en.wikipedia.org/w/api.php?action=query&format=json&meta=tokens");

		try {
			// Add your data
			/*
			 * List<NameValuePair> nameValuePairs = new
			 * ArrayList<NameValuePair>(1); nameValuePairs.add(new
			 * BasicNameValuePair("meta", "tokens")); httppost.setEntity(new
			 * UrlEncodedFormEntity(nameValuePairs));
			 */
			// Execute HTTP Post Request
			// HttpResponse response = httpclient.execute(httppost);
			// String responseBody = EntityUtils.toString(response.getEntity());
			String responseBody = fetch(url_server
					+ "action=query&format=json&meta=tokens");
			// return responseBody;
			// Log.d("ResponseBody", responseBody);
			System.out.println("" + responseBody);
			String edittoken = null;
			String starttimestamp = null;
			JSONObject reader;
			JSONObject queryJSONObject;
			JSONObject tokensJSONObject;
			JSONObject minus1JSONObject;

			try {
				// Log.d(">>>>>>>>>>>>>>>>>>>>>>", responseBody);
				reader = new JSONObject(responseBody);
				queryJSONObject = reader.getJSONObject("query");
				tokensJSONObject = queryJSONObject.getJSONObject("tokens");
				edittoken = tokensJSONObject.getString("csrftoken");
				// Log.d("edittoken", edittoken);
				return (edittoken);

			} catch (JSONException e) {
				e.printStackTrace();
				return null;
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return "WRONG";
	}

	public static boolean areCoordinatesPresent(String title) {
		String url = url_server
				+ "action=query&prop=coordinates&format=json&titles=" + title;
		try {
			String receivedJSON = fetch(url);
			try {
				JSONObject reader = new JSONObject(receivedJSON);
				JSONObject query = reader.getJSONObject("query");
				JSONObject pages = reader.getJSONObject("pages");
				for (Iterator key = pages.keys(); key.hasNext();) {
					JSONObject pageID = pages.getJSONObject(key.next()
							.toString());
					JSONObject coordinates = pageID
							.getJSONObject("coordinates");
					if (coordinates.has("lat") && coordinates.has("lon")) {
						return true;
					} else {
						return false;
					}
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String makeEdit(String title, String state,
			String wpEditToken, String starttimestamp, String latd,
			String latm, String lats, String latns, String longd, String longm,
			String longs, String longew) {
		// HttpClient httpclient = new DefaultHttpClient();
		// HttpPost httppost = new HttpPost(
		// "https://en.wikipedia.org/w/api.php?action=edit&format=json");

		try {
			// Add your data
			// List<NameValuePair> nameValuePairs = new
			// ArrayList<NameValuePair>(1);
			// nameValuePairs.add(new BasicNameValuePair("title", title));
			// nameValuePairs.add(new BasicNameValuePair("token", token));
			// nameValuePairs.add(new BasicNameValuePair("starttimestamp",
			// starttimestamp));
			String prependtext = "";
			// nameValuePairs.add(new BasicNameValuePair("prependtext",
			// prependtext));
			// nameValuePairs.add(new BasicNameValuePair("contentformat",
			// "text/x-wiki"));
			// nameValuePairs.add(new BasicNameValuePair("contentmodel",
			// "wikitext"));
			// httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			// protection and token

			// post data
			StringBuilder buffer = new StringBuilder(300000);
			buffer.append("&title=");
			buffer.append(URLEncoder.encode(title, "UTF-8"));
			buffer.append("&prependtext=");
			buffer.append(prependtext);
			buffer.append("&token=");
			buffer.append(URLEncoder.encode(wpEditToken, "UTF-8"));
			buffer.append("&minor=1");
			String responseBody = post(url_server + "action=edit&format=json",
					buffer.toString());

			// done

			// Execute HTTP Post Request
			// HttpResponse response = httpclient.execute(httppost);
			// String responseBody = EntityUtils.toString(response.getEntity());

			JSONObject reader;
			JSONObject editJSONObject;

			try {
				reader = new JSONObject(responseBody);
				editJSONObject = reader.getJSONObject("edit");
				String resultstr = editJSONObject.getString("result");
				return resultstr;

			} catch (JSONException e) {
				e.printStackTrace();
				return null;
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return null;
	}

	// return "WRONG";

	public static String makeEdit(String title, String text, String wpEditToken) {
		// HttpClient httpclient = new DefaultHttpClient();
		// HttpPost httppost = new HttpPost(
		// "https://en.wikipedia.org/w/api.php?action=edit&format=json");

		try {
			// Add your data
			// List<NameValuePair> nameValuePairs = new
			// ArrayList<NameValuePair>(1);
			// nameValuePairs.add(new BasicNameValuePair("title", title));
			// nameValuePairs.add(new BasicNameValuePair("token", token));
			// nameValuePairs.add(new BasicNameValuePair("starttimestamp",
			// starttimestamp));
			String prependtext = text;
			// nameValuePairs.add(new BasicNameValuePair("prependtext",
			// prependtext));
			// nameValuePairs.add(new BasicNameValuePair("contentformat",
			// "text/x-wiki"));
			// nameValuePairs.add(new BasicNameValuePair("contentmodel",
			// "wikitext"));
			// httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			// protection and token

			// post data
			StringBuilder buffer = new StringBuilder(300000);
			// buffer.append("?action=");
			// buffer.append("edit");
			// buffer.append("&format=");
			// buffer.append("json");
			buffer.append("&token=");
			buffer.append(URLEncoder.encode(wpEditToken, "UTF-8"));
			buffer.append("&minor=1");
			buffer.append("&title=");
			buffer.append(URLEncoder.encode(title, "UTF-8"));
			buffer.append("&prependtext=");
			buffer.append(URLEncoder.encode(prependtext, "UTF-8"));

			// System.out.println(buffer.toString());
			String responseBody = postp(url_server + "action=edit&format=json",
					buffer.toString());
			// String responseBody=null;
			// done

			System.out.println("" + responseBody);

			// Execute HTTP Post Request
			// HttpResponse response = httpclient.execute(httppost);
			// String responseBody = EntityUtils.toString(response.getEntity());

			JSONObject reader;
			JSONObject editJSONObject;

			try {
				reader = new JSONObject(responseBody);
				editJSONObject = reader.getJSONObject("edit");
				String resultstr = editJSONObject.getString("result");
				return resultstr;

			} catch (JSONException e) {
				e.printStackTrace();
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	protected static URLConnection makeConnection(String url)
			throws IOException {
		return new URL(url).openConnection();
	}

	protected static void setCookies(URLConnection u) {
		StringBuilder cookie = new StringBuilder(100);
		for (Map.Entry<String, String> entry : cookies.entrySet()) {
			cookie.append(entry.getKey());
			cookie.append("=");
			cookie.append(entry.getValue());
			cookie.append("; ");
		}
		u.setRequestProperty("Cookie", cookie.toString());
	}

	public static ArrayList<String> search(String title) {
		ArrayList<String> searchResults = new ArrayList<String>();
		try {
			String fetchedJson = fetch(url_server
					+ "action=query&list=search&format=json&srsearch=" + title
					+ "&srlimit=50");
			// //Log.d("searchResult", fetchedJson);
			JSONObject reader;

			try {
				reader = new JSONObject(fetchedJson);
				JSONObject queryObject = reader.getJSONObject("query");
				JSONArray searchedArray = queryObject.getJSONArray("search");
				for (int i = 0; i < searchedArray.length(); ++i) {
					JSONObject rec = searchedArray.getJSONObject(i);
					String thisTitle = rec.getString("title");
					searchResults.add(i, thisTitle);
				}
			} catch (JSONException e) {
				e.printStackTrace();
				return null;
			}
			return searchResults;
		} catch (IOException e) {
			return null;
		}
	}

	private static void grabCookies(URLConnection u) {
		String headerName;
		for (int i = 1; (headerName = u.getHeaderFieldKey(i)) != null; i++)
			if (headerName.equals("Set-Cookie")) {
				String cookie = u.getHeaderField(i);
				cookie = cookie.substring(0, cookie.indexOf(';'));
				String name = cookie.substring(0, cookie.indexOf('='));
				String value = cookie.substring(cookie.indexOf('=') + 1,
						cookie.length());
				// these cookies were pruned, but are still sent for some
				// reason?
				// TODO: when these cookies are no longer sent, remove this test
				if (!value.equals("deleted"))
					cookies.put(name, value);
			}
	}

	public static String getPageData(String title) {
		return null;
	}

	protected static String post(String url, String text) throws IOException {
		URLConnection connection = makeConnection(url);
		setCookies(connection);
		connection.setDoOutput(true);
		connection.connect();
		try {
			OutputStreamWriter out = new OutputStreamWriter(
					connection.getOutputStream(), "UTF-8");
			out.write(text);
		} catch (Exception e) {
		}

		StringBuilder temp = new StringBuilder(100000);
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "UTF-8"));
			grabCookies(connection);
			String line;
			while ((line = in.readLine()) != null) {
				temp.append(line);
				temp.append("\n");
			}
		} catch (Exception ex) {
		}
		return temp.toString();
	}

	protected static String postp(String url, String text) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		setCookies(connection);
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.connect();
		try {
			// OutputStreamWriter out = new
			// OutputStreamWriter(connection.getOutputStream(), "UTF-8");
			// out.write(text);
			DataOutputStream wr = new DataOutputStream(
					connection.getOutputStream());
			wr.writeBytes(text);
			wr.flush();
			wr.close();
		} catch (Exception e) {
		}

		StringBuilder temp = new StringBuilder(100000);
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "UTF-8"));
			grabCookies(connection);
			String line;
			while ((line = in.readLine()) != null) {
				temp.append(line);
				temp.append("\n");
			}
		} catch (Exception ex) {
		}
		return temp.toString();
	}

	protected static String fetch(String url) throws IOException {
		// connect
		URLConnection connection = makeConnection(url);
		setCookies(connection);
		connection.connect();
		grabCookies(connection);

		// check lag

		String temp = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "UTF-8"));
			String line;
			StringBuilder text = new StringBuilder(100000);
			while ((line = in.readLine()) != null) {
				text.append(line);
				text.append("\n");
			}
			temp = text.toString();
		} catch (Exception exp) {
		}
		return temp;
	}
}