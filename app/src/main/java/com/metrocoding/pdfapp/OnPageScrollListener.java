package com.metrocoding.pdfapp;

public interface OnPageScrollListener {

    /**
     * Called on every move while scrolling
     *
     * @param page current page index
     * @param positionOffset see {@link com.github.barteksc.pdfviewer.PDFView#getPositionOffset()}
     */
    void onPageScrolled(int page, float positionOffset);
}
