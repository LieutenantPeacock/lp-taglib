# Lt. Peacock Taglib
This JSP Taglib provides some common utility features.

## Installation
JDK 8 is required at a minimum.

This project is available as a [Maven artifact](https://search.maven.org/artifact/com.lt-peacock/lp-taglib). Maven users can include it with the following dependency in pom.xml:

```xml
<dependency>
    <groupId>com.lt-peacock</groupId>
    <artifactId>lp-taglib</artifactId>
    <version>1.0.0</version>
</dependency>
```

Then add the taglib declaration at the top of any JSP file and all the tags in this taglib will be available.

```jsp
<%@ taglib prefix="lp" uri="http://lt-peacock.com/tags"%>
```
## Pagination
When displaying a large amount of data, it is often convenient to split it into pages. This taglib provides a `pagination` tag for generating a list of page numbers to facilitate user navigation.

### Syntax

```jsp
<lp:pagination currentPage="7" firstPage="1" lastPage="20" basePageLink="/page"/>
```

The element will be replaced by an unordered list (`<ul>`) element. Each page will be a list item (`<li>`) with an anchor (`<a>`) inside. Each anchor points to the configured base page link with slash (`/`) and the page number appended. There is no CSS applied by default: it is up to the user to style the classes on the generated elements. The classes used for certain generated elements can be configured by setting some attributes.

### Attributes
All dynamic expressions (Java expressions, EL expressions, etc) are supported as attribute values.

Attributes are specified on the `lp:pagination` tag with the syntax `attributeName="attributeValue"`.

<table>
	<tr>
		<th>Attribute Name</th>
		<th>Description</th>
		<th>Default Value</th>
	</tr>
	<tr>
		<td>currentPage</td>
		<td>The current page number.</td>
		<td>None; this attribute is required.</td>
	</tr>
	<tr>
		<td>firstPage</td>
		<td>The first page number. This page number is not necessarily displayed.</td>
		<td><code>1</code></td>
	</tr>
	<tr>
		<td>lastPage</td>
		<td>The last page number. This page number is not necessarily displayed.</td>
		<td>None; this attribute is required.</td>
	</tr>
	<tr>
		<td>maxPages</td>
		<td>The maximum number of pages to display in the list.</td>
		<td><code>10</code></td>
	</tr>
	<tr>
		<td>pageGenerator</td>
		<td>The <code>com.ltpeacock.taglib.pagination.PageGenerator</code> object to use for generating pages.</td>
		<td><code>com.ltpeacock.taglib.pagination.DefaultPageGenerator</code></td>
	</tr>
	<tr>
		<td>pageLinkGenerator</td>
		<td>The <code>com.ltpeacock.taglib.pagination.PageLinkGenerator</code> object to use for generating page links.</td>
		<td><code>com.ltpeacock.taglib.pagination.DefaultPageLinkGenerator</code></td>
	</tr>
	<tr>
		<td>generatePrevLink</td>
		<td>Whether or not to generate a link (at the start of the list of pages) pointing to the previous page. The value should be a boolean (either <code>true</code> or <code>false</code>).</td>
		<td><code>true</code></td>
	</tr>
	<tr>
		<td>generateNextLink</td>
		<td>Whether or not to generate a link (at the end of the list of pages) pointing to the next page. The value should be a boolean (either <code>true</code> or <code>false</code>).</td>
		<td><code>true</code></td>
	</tr>
	<tr>
		<td>generateFirstLink</td>
		<td>Whether or not to generate a link (at the start of the list of pages) pointing to the first page. The value should be a boolean (either <code>true</code> or <code>false</code>).</td>
		<td><code>true</code></td>
	</tr>
	<tr>
		<td>generateLastLink</td>
		<td>Whether or not to generate a link (at the end of the list of pages) pointing to the last page. The value should be a boolean (either <code>true</code> or <code>false</code>).</td>
		<td><code>true</code></td>
	</tr>
	<tr>
		<td>generateDisabledLinks</td>
		<td>Whether or not to generate disabled first, last, previous, and next links. The first and previous links would be disabled when the current page is the first page; the last and next links would be disabled when the current page is the last page. The value should be a boolean (either <code>true</code> or <code>false</code>).</td>
		<td><code>false</code></td>
	</tr>
	<tr>
		<td>currentClass</td>
		<td>The CSS class to add to the list item for the current page (in addition to the page class).</td>
		<td><code>"current"</code></td>
	</tr>
	<tr>
		<td>pageClass</td>
		<td>The CSS class to add to the list item elements for all pages.</td>
		<td><code>"page"</code></td>
	</tr>
	<tr>
		<td>pageLinkClass</td>
		<td>The CSS class to add to the anchor in the list item for each page.</td>
		<td><code>"page-link"</code></td>
	</tr>
	<tr>
		<td>rootClass</td>
		<td>The CSS class to add to the unordered list element that the <code>lp:pagination</code> tag is replaced with.</td>
		<td><code>"pagination"</code></td>
	</tr>
	<tr>
		<td>prevClass</td>
		<td>The CSS class to add to the list item for the previous page link.</td>
		<td><code>"prev-page"</code></td>
	</tr>
	<tr>
		<td>nextClass</td>
		<td>The CSS class to add to the list item for the next page link.</td>
		<td><code>"next-page"</code></td>
	</tr>
	<tr>
		<td>firstClass</td>
		<td>The CSS class to add to the list item for the first page link.</td>
		<td><code>"first-page"</code></td>
	</tr>
	<tr>
		<td>lastClass</td>
		<td>The CSS class to add to the list item for the last page link.</td>
		<td><code>"last-page"</code></td>
	</tr>
	<tr>
		<td>disabledClass</td>
		<td>The CSS class to add to all disabled list items.</td>
		<td><code>"disabled"</code></td>
	</tr>
	<tr>
		<td>prevText</td>
		<td>The content of the previous page link.</td>
		<td><code>"&laquo; Prev"</code></td>
	</tr>
	<tr>
		<td>nextText</td>
		<td>The content of the next page link.</td>
		<td><code>"Next &raquo;"</code></td>
	</tr>
	<tr>
		<td>firstText</td>
		<td>The content of the first page link.</td>
		<td><code>"First"</code></td>
	</tr>
	<tr>
		<td>lastText</td>
		<td>The content of the last page link.</td>
		<td><code>"Last"</code></td>
	</tr>
	<tr>
		<td>basePageLink</td>
		<td>The base page link for pages. The <code>href</code> for each page link will be the base page link appended with a slash and the page number. (If the specified value ends in a slash, it will first be removed.)</td>
		<td><code>"javascript:;"</code></td>
	</tr>
</table>

### Example

This example uses Bootstrap 4 to style the pagination element. For this integration, the `pageClass` and `currentClass` attributes need to be set to match the Bootstrap classes. (The default `rootClass` of `"pagination"` and `pageLinkClass` of `"page-link"` already match.)

```jsp
<%@ taglib prefix="lp" uri="http://lt-peacock.com/tags"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Pagination Example</title>
<link rel="stylesheet" 
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
      crossorigin="anonymous">
</head>
<body>
<div class="container">
	<!-- Content of current page here ... -->
	
	<c:url value="/page" var="pageLink"/>
	<!-- Pagination element -->
	<lp:pagination currentPage="7" firstPage="1" lastPage="20" maxPages="10"
		basePageLink="${pageLink}" rootClass="pagination" currentClass="active"
		pageClass="page-item" generateDisabledLinks="true"/>
</div>
</body>
</html>
```

Result:

<img src="docs/PaginationExample.PNG">

The generated HTML (prettified):

```html
<ul class='pagination'>
	<li class='page-item first-page'><a class='page-link'
		href='/page/1'>First</a></li>
	<li class='page-item prev-page'><a class='page-link'
		href='/page/6'>&laquo; Prev</a></li>
	<li class='page-item'><a class='page-link' href='/page/2'>2</a></li>
	<li class='page-item'><a class='page-link' href='/page/3'>3</a></li>
	<li class='page-item'><a class='page-link' href='/page/4'>4</a></li>
	<li class='page-item'><a class='page-link' href='/page/5'>5</a></li>
	<li class='page-item'><a class='page-link' href='/page/6'>6</a></li>
	<li class='page-item active'><a class='page-link' href='/page/7'>7</a></li>
	<li class='page-item'><a class='page-link' href='/page/8'>8</a></li>
	<li class='page-item'><a class='page-link' href='/page/9'>9</a></li>
	<li class='page-item'><a class='page-link' href='/page/10'>10</a></li>
	<li class='page-item'><a class='page-link' href='/page/11'>11</a></li>
	<li class='page-item next-page'><a class='page-link'
		href='/page/8'>Next &raquo;</a></li>
	<li class='page-item last-page'><a class='page-link'
		href='/page/20'>Last</a></li>
</ul>
```