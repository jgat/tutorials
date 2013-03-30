all: midsem.pdf week2.pdf week3.pdf week4.pdf assign1.pdf week5.pdf week6.pdf

%.pdf: src/%.tex
	pdflatex $<

clean:
	rm *.{aux,log,nav,out,snm,toc,pdf}
