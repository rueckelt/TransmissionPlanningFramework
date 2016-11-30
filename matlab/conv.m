function y=conv(x,h,show_flag)  
% 线性卷积的实现 y=x*h  
% if show_flag=1 plot x and result in matlab  
%  
% Author: xiahouzuoxin  
%   Date: 2013-11-21  
  
if nargin < 3  
  show_flag = 0;  
end  
  
N = length(x);  
M = length(h);  
L = M+N-1;  
  
y = zeros(L,1);  
  
for n=1:N  
  for k=1:M  
    y(n+k-1) = y(n+k-1) + x(n)*h(k);  
  end   
end  
  
if show_flag == 1  
  figure,  
  max_val = max([max(y),max(x),max(h)]);  
  subplot(1,2,1),stem(x);title('speed');grid on;axis([0 10 0 16])  
  subplot(1,2,2),stem(h);title('speed x 2');grid on;axis([0 10 0 16])  
%  subplot(2,2,3),stem(y);title('y(n)');grid on;axis([0 L 0 max_val])  
end 