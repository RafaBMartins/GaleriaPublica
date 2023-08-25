package barbosa.martins.rafael.galeriapublica;

import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;

public class ListAdapter extends PagingDataAdapter<ImageData, MyViewHolder> {

    public ListAdapter(@NonNull DiffUtil.ItemCallback<ImageData> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ImageData imageData = getItem(position);
        TextView tvName = holder.itemView.findViewById(R.id.tvListName);
        tvName.setText(ImageData.fileName);

        TextView tvdate = holder.itemView.findViewById(R.id.tvListDate);
        tvdate.setText("Data: " + new SimpleDateFormat("HH:mm dd/MM/yyyy").format(imageData.date));

        TextView tvSize = holder.itemView.findViewById(R.id.tvListSize);
        tvSize.setText("Tamanho: " + String.valueOf(imageData.size));

        Bitmap thumb = imageData.thumb;
        ImageView imageView = holder.itemView.findViewById(R.id.imvListItem);
        imageView.setImageBitmap(thumb);
    }
}
