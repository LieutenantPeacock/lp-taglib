package com.ltpeacock.taglib.pagination;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * The tag handler for the pagination tag.
 * @author LieutenantPeacock
 *
 */
public class PaginationTag extends SimpleTagSupport {
	private int currentPage;
	private int firstPage = 1;
	private int lastPage;
	private int maxPages = 10;
	private PageGenerator pageGenerator = new DefaultPageGenerator();
	private PageLinkGenerator pageLinkGenerator = new DefaultPageLinkGenerator();
	private boolean generatePrevLink = true;
	private boolean generateNextLink = true;
	private boolean generateFirstLink = true;
	private boolean generateLastLink = true;
	private boolean generateDisabledLinks = false;
	private String currentClass = "current";
	private String pageClass = "page";
	private String pageLinkClass = "page-link";
	private String rootClass = "pagination";
	private String prevClass = "prev-page";
	private String nextClass = "next-page";
	private String firstClass = "first-page";
	private String lastClass = "last-page";
	private String disabledClass = "disabled";
	private String prevText = "&laquo; Prev";
	private String nextText = "Next &raquo;";
	private String firstText = "First";
	private String lastText = "Last";
	private String basePageLink = "javascript:;";

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		final List<PageItem> pages = pageGenerator.generatePages(currentPage, firstPage, lastPage, maxPages);
		out.write("<ul class='" + rootClass + "'>");
		if (generateFirstLink && (firstPage != currentPage || generateDisabledLinks)) {
			out.write(getPageHTML(pageClass + " " + firstClass + (currentPage == firstPage ? " " + disabledClass : ""),
					firstPage, firstText));
		}
		if (generatePrevLink && (firstPage != currentPage || generateDisabledLinks)) {
			out.write(getPageHTML(pageClass + " " + prevClass + (currentPage == firstPage ? " " + disabledClass : ""),
					currentPage - 1, prevText));
		}
		for (final PageItem page : pages) {
			out.write(getPageHTML(pageClass + (page.getNumber() == currentPage ? " " + currentClass : ""),
					page.getNumber(), page.getText()));
		}
		if (generateNextLink && (lastPage != currentPage || generateDisabledLinks)) {
			out.write(getPageHTML(pageClass + " " + nextClass + (currentPage == lastPage ? " " + disabledClass : ""),
					currentPage + 1, nextText));
		}
		if (generateLastLink && (lastPage != currentPage || generateDisabledLinks)) {
			out.write(getPageHTML(pageClass + " " + lastClass + (currentPage == lastPage ? " " + disabledClass : ""),
					lastPage, lastText));
		}
		out.write("</ul>");
	}

	private String getPageHTML(final String cssClass, final int page, final String text) {
		return "<li class='" + cssClass.trim() + "'><a class='" + pageLinkClass + "' href='" 
				+ pageLinkGenerator.generateLink(basePageLink, page)
				+ "'>" + text + "</a></li>";
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public void setMaxPages(int maxPages) {
		this.maxPages = maxPages;
	}

	public void setPageGenerator(PageGenerator pageGenerator) {
		this.pageGenerator = pageGenerator;
	}

	public void setGeneratePrevLink(boolean generatePrevLink) {
		this.generatePrevLink = generatePrevLink;
	}

	public void setGenerateNextLink(boolean generateNextLink) {
		this.generateNextLink = generateNextLink;
	}

	public void setCurrentClass(String currentClass) {
		this.currentClass = currentClass;
	}

	public void setPageClass(String pageClass) {
		this.pageClass = pageClass;
	}

	public void setPageLinkClass(String pageLinkClass) {
		this.pageLinkClass = pageLinkClass;
	}

	public void setRootClass(String rootClass) {
		this.rootClass = rootClass;
	}

	public void setPrevClass(String prevClass) {
		this.prevClass = prevClass;
	}

	public void setNextClass(String nextClass) {
		this.nextClass = nextClass;
	}

	public void setDisabledClass(String disabledClass) {
		this.disabledClass = disabledClass;
	}

	public void setPrevText(String prevText) {
		this.prevText = prevText;
	}

	public void setNextText(String nextText) {
		this.nextText = nextText;
	}

	public void setBasePageLink(String basePageLink) {
		this.basePageLink = basePageLink.endsWith("/") ? basePageLink.substring(0, basePageLink.length() - 1)
				: basePageLink;
	}

	public void setGenerateFirstLink(boolean generateFirstLink) {
		this.generateFirstLink = generateFirstLink;
	}

	public void setGenerateLastLink(boolean generateLastLink) {
		this.generateLastLink = generateLastLink;
	}

	public void setFirstText(String firstText) {
		this.firstText = firstText;
	}

	public void setLastText(String lastText) {
		this.lastText = lastText;
	}

	public void setGenerateDisabledLinks(boolean generateDisabledLinks) {
		this.generateDisabledLinks = generateDisabledLinks;
	}

	public void setFirstClass(String firstClass) {
		this.firstClass = firstClass;
	}

	public void setLastClass(String lastClass) {
		this.lastClass = lastClass;
	}

	public void setPageLinkGenerator(PageLinkGenerator pageLinkGenerator) {
		this.pageLinkGenerator = pageLinkGenerator;
	}
}
